package com.poeticcoder.ai.chat;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.searches.AllClassesSearch;
import com.intellij.psi.util.PsiUtilCore;
import com.intellij.util.Query;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.editor.Document;
import com.intellij.psi.PsiManager;

import java.util.Collection;

/**
 * 代码定位工具类
 * 用于在项目中查找和定位类、文件、方法等代码元素
 */
public class CodeLocator {

    /**
     * 根据类名查找类
     */
    public static PsiClass findClass(Project project, String name) {
        JavaPsiFacade facade = JavaPsiFacade.getInstance(project);
        PsiClass byFqn = facade.findClass(name, GlobalSearchScope.projectScope(project));
        if (byFqn != null) return byFqn;
        Query<PsiClass> q = AllClassesSearch.search(GlobalSearchScope.projectScope(project), project);
        for (PsiClass c : q.findAll()) {
            if (c.getName() != null && c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    /**
     * 根据文件名查找文件
     */
    public static PsiFile findFile(Project project, String filename) {
        Collection<VirtualFile> virtualFiles = com.intellij.psi.search.FilenameIndex.getVirtualFilesByName(
            filename, GlobalSearchScope.projectScope(project));
        if (virtualFiles.isEmpty()) return null;
        VirtualFile virtualFile = virtualFiles.iterator().next();
        return PsiManager.getInstance(project).findFile(virtualFile);
    }

    /**
     * 根据路径查找文件
     */
    public static PsiFile findFileByPath(Project project, String path) {
        if (path == null || path.isEmpty()) return null;
        VirtualFile vf = LocalFileSystem.getInstance().findFileByPath(path);
        if (vf == null && project.getBasePath() != null) {
            String p2 = project.getBasePath() + (path.startsWith("/") ? path : "/" + path);
            vf = LocalFileSystem.getInstance().findFileByPath(p2);
        }
        return vf != null ? PsiManager.getInstance(project).findFile(vf) : null;
    }

    /**
     * 在类中查找方法
     */
    public static PsiMethod findMethod(PsiClass cls, String methodName) {
        if (cls == null) return null;
        for (PsiMethod m : cls.getMethods()) {
            if (m.getName().equals(methodName)) return m;
        }
        return null;
    }

    /**
     * 获取代码片段
     */
    public static String snippet(PsiElement element, int maxChars) {
        if (element == null) return "";
        String text = element.getText();
        if (text == null) return "";
        if (text.length() > maxChars) return text.substring(0, maxChars);
        return text;
    }

    /**
     * 获取文件指定行范围的代码片段
     */
    public static String snippet(PsiFile file, int startLine, int endLine) {
        if (file == null) return "";
        Document doc = com.intellij.openapi.editor.EditorFactory.getInstance().createDocument(file.getText());
        int max = doc.getLineCount();
        int s = Math.max(0, Math.min(startLine - 1, max - 1));
        int e = Math.max(s, Math.min(endLine - 1, max - 1));
        int startOffset = doc.getLineStartOffset(s);
        int endOffset = doc.getLineEndOffset(e);
        return doc.getText(new com.intellij.openapi.util.TextRange(startOffset, endOffset));
    }

    /**
     * 获取元素所在行号
     */
    public static int line(Project project, PsiElement element) {
        if (element == null) return 0;
        PsiFile file = element.getContainingFile();
        if (file == null) return 0;
        Document doc = com.intellij.openapi.editor.EditorFactory.getInstance().createDocument(file.getText());
        int offset = element.getTextOffset();
        return doc.getLineNumber(offset) + 1;
    }

    /**
     * 获取元素对应的虚拟文件
     */
    public static VirtualFile vfile(PsiElement element) {
        return element == null ? null : PsiUtilCore.getVirtualFile(element);
    }

    /**
     * 在编辑器中打开并定位到指定元素
     */
    public static void open(Project project, PsiElement element) {
        VirtualFile vf = vfile(element);
        if (vf == null) return;
        int line = line(project, element) - 1;
        new OpenFileDescriptor(project, vf, line, 0).navigate(true);
        FileEditorManager.getInstance(project).openTextEditor(
            new OpenFileDescriptor(project, vf, line, 0), true);
    }
}

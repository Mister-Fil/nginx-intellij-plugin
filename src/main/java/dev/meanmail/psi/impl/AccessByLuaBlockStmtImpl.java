// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import dev.meanmail.psi.AccessByLuaBlockStmt;
import dev.meanmail.psi.LuaBlockStmt;
import dev.meanmail.psi.Visitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AccessByLuaBlockStmtImpl extends ASTWrapperPsiElement implements AccessByLuaBlockStmt {

    public AccessByLuaBlockStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull Visitor visitor) {
        visitor.visitAccessByLuaBlockStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof Visitor) accept((Visitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public LuaBlockStmt getLuaBlockStmt() {
        return findChildByClass(LuaBlockStmt.class);
    }

}

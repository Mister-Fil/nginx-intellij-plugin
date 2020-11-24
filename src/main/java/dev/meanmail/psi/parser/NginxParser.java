// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LightPsiParser;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;

import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import static dev.meanmail.psi.Types.*;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class NginxParser implements PsiParser, LightPsiParser {

    static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
        return nginxFile(b, l + 1);
    }

    /* ********************************************************** */
    // LBRACE statements* RBRACE
    public static boolean block_stmt(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "block_stmt")) return false;
        if (!nextTokenIs(b, LBRACE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, BLOCK_STMT, null);
        r = consumeToken(b, LBRACE);
        p = r; // pin = 1
        r = r && report_error_(b, block_stmt_1(b, l + 1));
        r = p && consumeToken(b, RBRACE) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // statements*
    private static boolean block_stmt_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "block_stmt_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!statements(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "block_stmt_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // name_stmt wsps value_stmt* wsps (SEMICOLON | block_stmt)
    public static boolean directive_stmt(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "directive_stmt")) return false;
        if (!nextTokenIs(b, IDENTIFIER)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DIRECTIVE_STMT, null);
        r = name_stmt(b, l + 1);
        p = r; // pin = 1
        r = r && report_error_(b, wsps(b, l + 1));
        r = p && report_error_(b, directive_stmt_2(b, l + 1)) && r;
        r = p && report_error_(b, wsps(b, l + 1)) && r;
        r = p && directive_stmt_4(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // value_stmt*
    private static boolean directive_stmt_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "directive_stmt_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!value_stmt(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "directive_stmt_2", c)) break;
        }
        return true;
    }

    // SEMICOLON | block_stmt
    private static boolean directive_stmt_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "directive_stmt_4")) return false;
        boolean r;
        r = consumeToken(b, SEMICOLON);
        if (!r) r = block_stmt(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // IDENTIFIER
    public static boolean name_stmt(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "name_stmt")) return false;
        if (!nextTokenIs(b, IDENTIFIER)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, IDENTIFIER);
        exit_section_(b, m, NAME_STMT, r);
        return r;
    }

    /* ********************************************************** */
    // statements*
    static boolean nginxFile(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "nginxFile")) return false;
        while (true) {
            int c = current_position_(b);
            if (!statements(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "nginxFile", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // wsps stmts wsps COMMENT?
    static boolean statements(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "statements")) return false;
        if (!nextTokenIs(b, "", IDENTIFIER, WHITE_SPACE)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = wsps(b, l + 1);
        r = r && stmts(b, l + 1);
        r = r && wsps(b, l + 1);
        r = r && statements_3(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMENT?
    private static boolean statements_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "statements_3")) return false;
        consumeToken(b, COMMENT);
        return true;
    }

    /* ********************************************************** */
    // (
    //                    directive_stmt
    //                    )
    static boolean stmts(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "stmts")) return false;
        if (!nextTokenIs(b, IDENTIFIER)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = directive_stmt(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // QUOTE STRING QUOTE
    public static boolean string_stmt(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "string_stmt")) return false;
        if (!nextTokenIs(b, QUOTE)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, QUOTE, STRING, QUOTE);
        exit_section_(b, m, STRING_STMT, r);
        return r;
    }

    /* ********************************************************** */
    // IDENTIFIER
    //                | VALUE
    //                | string_stmt
    public static boolean value_stmt(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "value_stmt")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, VALUE_STMT, "<value stmt>");
        r = consumeToken(b, IDENTIFIER);
        if (!r) r = consumeToken(b, VALUE);
        if (!r) r = string_stmt(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // WHITE_SPACE?
    static boolean wsps(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "wsps")) return false;
        consumeToken(b, WHITE_SPACE);
        return true;
    }

    public ASTNode parse(IElementType t, PsiBuilder b) {
        parseLight(t, b);
        return b.getTreeBuilt();
    }

    public void parseLight(IElementType t, PsiBuilder b) {
        boolean r;
        b = adapt_builder_(t, b, this, null);
        Marker m = enter_section_(b, 0, _COLLAPSE_, null);
        r = parse_root_(t, b);
        exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
    }

    protected boolean parse_root_(IElementType t, PsiBuilder b) {
        return parse_root_(t, b, 0);
    }

}

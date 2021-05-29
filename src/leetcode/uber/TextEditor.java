package leetcode.uber;

import java.util.Stack;

/**
 * 字符串处理，模拟textx, 有TYPE, Select, move_cursor, undo操作
 * 例子：(右边表示结果，| 表示cursor）
 * TYPE SIGNAL      -> SIGNAL|
 * TYPE CODE      -> SIGNALCODE|
 * MOVE_CURSOR  -3       -> SIGNALC|ODE
 * SELECT 5 8           ->  SIGNALCO|DE
 * TYPE IN           -> SIGNAIN|DE
 * UNDO        -> SIGNALCO|DE
 *
 * https://leetcode.com/discuss/interview-question/860501/text-editor-implementation
 * https://leetcode.com/discuss/interview-question/304048/google-onsite-interview-design-text-editor
 * 这两个需要结合起来，用stack 把光标标记位置
 *
 * https://www.careercup.com/question?id=5726975948226560
 */
public class TextEditor {
    private Stack<Edit> history;
    private CharNode cursor;
    private CharNode head, tail;
    private CharNode selectStart;

    public TextEditor() {
        this.history = new Stack<>();
        this.head = new CharNode('\0');
        this.tail = new CharNode('\0');
        head.next = tail;
        tail.prev = head;
        this.cursor = tail;
    }

    public void moveCursorLeft() {
        if (cursor.prev == head) return;
        cursor = cursor.prev;
        selectStart = null;
        history.push(new Edit("RIGHT", null));
    }

    public void moveCursorRight() {
        if (cursor == tail) return;
        cursor = cursor.next;
        selectStart = null;
        history.push(new Edit("LEFT", null));
    }

    public void insertString(String s) {
        for (char c : s.toCharArray()) {
            insertCharacter(c);
        }
    }

    public void insertCharacter(char ch) {
        insert(new CharNode(ch));
        history.push(new Edit("DELETE", null));
    }

    private void insert(CharNode node) {
        if (selectStart == null) {
            CharNode prev = cursor.prev;
            if (prev != null) {
                prev.next = node;
                node.prev= prev;
            }
            node.next = cursor;
            cursor.prev = node;
        } else {
            selectStart.next = node;
            node.prev = selectStart;
            node.next = cursor;
            cursor.prev = node;
            selectStart = null;
        }
    }

    public void moveCursor(int x) {
        if (x < 0) {
            for (int i = 0; i < Math.abs(x); i++) {
                moveCursorLeft();
            }
        } else if (x > 0) {
            for (int i = 0; i < x; i++) {
                moveCursorRight();
            }
        }
    }

    public void backspace() {
        if (cursor.prev == head) return;
        history.push(new Edit("INSERT", delete(cursor.prev)));
    }

    private CharNode delete(CharNode node) {
        if (node == null || node == head)
            return null;
        if (node.prev != null) {
            node.prev.next = cursor;
        }
        cursor.prev = node.prev;
        return node;
    }

    public void select(int start, int end) {
        CharNode n = head;
        for (int i = 0; i < start; i++) {
            n = n.next;
        }
        selectStart = n;
        for (int i = 0; i < end - start + 1; i++) {
            n = n.next;
        }
        cursor = n;
    }

    public void undo() {
        if (history.isEmpty()) return;
        Edit edit = history.pop();
        switch (edit.edition) {
            case "LEFT":
                cursor = cursor.prev;
                break;
            case "RIGHT":
                cursor = cursor.next;
                break;
            case "DELETE":
                delete(cursor.prev);
                break;
            case "INSERT":
                insert(edit.data);
                break;
            default:
                return;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CharNode n = head.next;
        while (n != null) {
            if (n == cursor) sb.append('|');
            if (n == tail) break;
            sb.append(n.ch);
            n = n.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        System.out.println(textEditor.toString());
        textEditor.insertCharacter('a');
        System.out.println(textEditor.toString());
        textEditor.insertCharacter('b');
        System.out.println(textEditor.toString());
        textEditor.insertCharacter('c');
        System.out.println(textEditor.toString());
        textEditor.moveCursorLeft();
        System.out.println(textEditor.toString());
        textEditor.moveCursorLeft();
        System.out.println(textEditor.toString());
        textEditor.backspace();
        System.out.println(textEditor.toString());
        textEditor.moveCursorLeft();
        System.out.println(textEditor.toString());
        textEditor.moveCursorRight();
        System.out.println(textEditor.toString());
        textEditor.backspace();
        System.out.println(textEditor.toString());
        textEditor.undo();
        System.out.println(textEditor.toString());
        textEditor.undo();
        System.out.println(textEditor.toString());
        textEditor.undo();
        System.out.println(textEditor.toString());
        textEditor.undo();
        System.out.println(textEditor.toString());
        textEditor.undo();
        System.out.println(textEditor.toString());
        textEditor.moveCursor(-2);
        System.out.println(textEditor.toString());
        textEditor.moveCursor(1);
        System.out.println(textEditor.toString());
        textEditor.moveCursor(3);
        System.out.println(textEditor.toString());
        textEditor.backspace();
        System.out.println(textEditor.toString());
        textEditor.backspace();
        System.out.println(textEditor.toString());
        textEditor.backspace();
        System.out.println(textEditor.toString());
        textEditor.insertString("SIGNAL");
        System.out.println(textEditor.toString());
        textEditor.insertString("CODE");
        System.out.println(textEditor.toString());
        textEditor.select(5, 8);
        System.out.println(textEditor.toString());
        textEditor.insertString("IN");
        System.out.println(textEditor.toString());
    }


}

class Edit {
    String edition;
    CharNode data;

    public Edit(String edition, CharNode curr) {
        this.edition = edition;
        this.data = curr;
    }
}

class CharNode {
    char ch;
    CharNode prev;
    CharNode next;

    public CharNode(char ch) {
        this.ch = ch;
    }
}
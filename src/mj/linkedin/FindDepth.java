package mj.linkedin;

/**
 * http://wxx5433.github.io/find-depth.html

 Consider this string representation for binary trees. Each node is of the form (lr),
 where l represents the left child and r represents the right child. If l is the
 character 0, then there is no left child. Similarly, if r is the character 0,
 then there is no right child. Otherwise, the child can be a node of the form (lr),
 and the representation continues recursively. For example: (00) is a tree that
 consists of one node. ((00)0) is a two-node tree in which the root has a left child,
 and the left child is a leaf. And ((00)(00)) is a three-node tree, with a root, a left
 and a right child.

 Write a function that takes as input such a string, and returns -1 if the string is malformed,
 and the depth of the tree if the string is well-formed.

 find_depth('(00)') -> 0
 find_depth('((00)0)') -> 1
 find_depth('((00)(00))') -> 1
 find_depth('((00)(0(00)))') -> 2
 find_depth('((00)(0(0(00))))') -> 3
 find_depth('x') -> -1
 find_depth('0') -> -1
 find_depth('()') -> -1
 find_depth('(0)') -> -1
 find_depth('(00)x') -> -1
 find_depth('(0p)') -> -1
 */
public class FindDepth {

    public static int getDepth(String str) {
        int depth = -1;

        return depth;
    }

}

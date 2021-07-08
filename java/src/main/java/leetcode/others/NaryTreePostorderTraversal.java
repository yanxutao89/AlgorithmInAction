package leetcode.others;

import leetcode.beans.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class NaryTreePostorderTraversal {

	/*
	 * Runtime: 4 ms, faster than 30.89% of Java online submissions for N-ary Tree Postorder Traversal.
	 * Memory Usage: 49.2 MB, less than 18.92% of Java online submissions for N-ary Tree Postorder Traversal.
	 */
	 public List<Integer> postorder(Node root) {

		 Stack<Node> elements = new Stack();
         List<Integer> postorderTraversal = new ArrayList<Integer>();
         Node currNode;

         elements.push(root);

         while(!elements.isEmpty()){
             currNode = elements.pop();

             if (currNode != null){
                 postorderTraversal.add(currNode.val);

                 for (int i = 0; i < currNode.children.size(); i++){
                     elements.push(currNode.children.get(i));
                 }
             }
         }

        return flipIntegerList(postorderTraversal);
    }

    private List<Integer> flipIntegerList(List<Integer> L){
        List<Integer> resList = new ArrayList<>(L.size());

        for (int i = L.size() -1; i >= 0; i--){
            resList.add(L.get(i));
        }

        return resList;
    }


	public static void main(String[] args) {


	}
}

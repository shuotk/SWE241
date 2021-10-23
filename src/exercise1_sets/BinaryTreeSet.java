package exercise1_sets;

public class BinaryTreeSet {
    private BinaryTree tree;

    public BinaryTreeSet(){
        tree = new BinaryTree();
    }

    public boolean add(String value){
        return tree.add(value);
    }

    public boolean contains(String value){
        return tree.contains(value);
    }

    public int size(){
        return tree.size();
    }

    public String toString(){
        return tree.toString();
    }
}

// This BinaryTree doesn't add duplicates by default
class BinaryTree{
    private TreeNode overallRoot;
    private int size;

    public BinaryTree(){
        overallRoot = null;
        size = 0;
    }

    public boolean add(String value){
        if(overallRoot == null){
            overallRoot = new TreeNode(value);
            size++;
        } else {
            return addHelper(overallRoot, value, true);
        }
        return true;
    }

    public int size(){
        return size;
    }

    public boolean contains(String value){
        return !addHelper(overallRoot, value, false);
    }

    private boolean addHelper(TreeNode current, String value, boolean insert){
        int compare = value.compareTo(current.getValue());
        boolean result = true;
        if(compare < 0){
            if(current.getLeft() != null){
                result = addHelper(current.getLeft(), value, insert);
            } else {
                if(insert) {
                    current.setLeft(new TreeNode(value));
                    size++;
                }
            }
        } else if(compare > 0){
            if(current.getRight() != null){
                result = addHelper(current.getRight(), value, insert);
            } else {
                if(insert) {
                    current.setRight(new TreeNode(value));
                    size++;
                }
            }
        } else {
            // Collision found
            return false;
        }
        return result;
    }

    public String toString(){
        return "[" + traverse(overallRoot) + "]";
    }

    private String traverse(TreeNode current){
        if(current == null){
            return "";
        } else {
            String result = current.toString();
            String left = traverse(current.getLeft());
            if(!left.equals("")){
                result = result + ", " + left;
            }
            String right = traverse(current.getRight());
            if(!right.equals("")){
                result = result + ", " + right;
             }
            return result;
        }
    }
}

class TreeNode{
    private String value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(String value){
        this.value = value;
        left = null;
        right = null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public String toString(){
        return value;
    }
}

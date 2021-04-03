public class tree_node {

    public tree_node _parent = null;
    public tree_node _child = null;
    public tree_node _leftSibling = null;
    public tree_node _rightSibling = null;
    public String _data = null;

    public void tree_node(String data){
        _data = data;
    }
}

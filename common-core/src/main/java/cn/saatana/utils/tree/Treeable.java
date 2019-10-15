package cn.saatana.utils.tree;

import java.util.List;

public interface Treeable<T> {
	TreeNode<T> convertToTreeNode();

	void formatChildren(List<T> children);

	String uniqueCode();
}

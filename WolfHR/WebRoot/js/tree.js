var tree = {
    zTree: '',
    pNode: '',
    setting: {
        isSimpleData: true,
        treeNodeKey: "mid",
        treeNodeParentKey: "pid",
        showLine: true,
        root: {
            isRoot: true,
            nodes: []
        },
        callback: {
            /**
             * @param {Object} event
             *     鼠标事件
             * @param {Object} treeId
             *     树的容器ID
             * @param {Object} treeNode
             *     当前点击的节点
             */
            expand: function(event, treeId, treeNode){
                tree.pNode = treeNode;
                tree.loadNodeByPNODE();
            }
        }
    },
    /**
     * 1、回调函数是由服务器端触发的，什么时候执行由服务器决定
     * 2、回调函数是由jQuery内核调用的
     * 3、客户端存在两个线程
     * 4、如果在js代码中，有一些代码要用到回调函数中的数据，那么这些代码必须放在回调函数中
     */
    loadTree: function(){
        $.post("menuitemAction_getAllMenuitem.action", null, function(data){
            $("#tree").zTree(tree.setting, data.menuitemList);
        });
    },
    /**
     * 一般情况下，如果一段代码中要用到一个变量，而这个变量的值是在回调函数中赋值的，这个时候一定要确保使用该函数时，回调函数已经执行了
     */
    loadRootNode: function(){
        var parameter = {
            pid: 0
        };
        $.post("menuitemAction_showMenuitemsByPid.action", parameter, function(data){
            tree.zTree = $("#tree").zTree(tree.setting, data.menuitemList);
        });
    },
    /**
     * 该方法是在点击父节点的+号的时候执行的，这就意味着在执行该方法的时候，树早已经生成了,所以才能用tree.zTree;
     */
    loadNodeByPNODE: function(){
        var parameter = {
            pid: tree.pNode.mid
        };
        if (!tree.zTree.getNodeByParam("pid", tree.pNode.mid)) {
            $.post("menuitemAction_showMenuitemsByPid.action", parameter, function(data){
                /**
                 * 把查询出来的子节点追加到父节点上
                 */
                tree.zTree.addNodes(tree.pNode, data.menuitemList, true);
            });
        }
    }
};
$().ready(function(){
    //tree.loadTree();
    tree.loadRootNode();
	//该方法能输出什么不确定：因为在执行该代码的时候，回调函数执行不确定，所以tree.zTree的赋值也不确定
    //alert(tree.zTree);
});

/**

 * 点击事件加载

 *   *  加载根节点

 *   *  点击该节点的+号，触发事件，加载该节点的子节点

 */


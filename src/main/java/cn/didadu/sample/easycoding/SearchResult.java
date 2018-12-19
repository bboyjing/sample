package cn.didadu.sample.easycoding;

/**
 * @author zhangjing
 * @date 2018/11/27
 * Comparable是自己和自己比
 */
public class SearchResult implements Comparable<SearchResult>{
    int relativeRatio;
    long count;
    int recentOrders;

    public SearchResult(int relativeRatio, long count) {
        this.relativeRatio = relativeRatio;
        this.count = count;
    }

    @Override
    public int compareTo(SearchResult o) {
        //  先比较相关度
        if (this.relativeRatio != o.relativeRatio) {
            return this.relativeRatio > o.relativeRatio ? 1 : -1;
        }

        // 相关度相等时再比较浏览
        if (this.count != o.count) {
            return this.count > o.count ? 1 : -1;
        }

        return 0;
    }

    public void setRecentOrders(int recentOrders) {
        this.recentOrders = recentOrders;
    }
}

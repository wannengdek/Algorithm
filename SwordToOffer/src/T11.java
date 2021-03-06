/*
 * P82面试题11：旋转数组的最小数字
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾 我们称之为数组的旋转
 * 输入一个递增排序的数组的一个旋转 输出旋转数组的最小元素
 * 例如 数组 {3, 4, 5, 1, 2} 为 {1, 2, 3, 4, 5} 的一个旋转，该数组的最小值为 1
 */
public class T11
{
	/*
	 * 思路：在不允许重复的情况下 可以用二分查找的思路解决
	 * 根据旋转数组的思想，旋转后的数组是一个由两个递增排序的数组所组成
	 * 最小元素为于两个子数组的交界处
	 * 若某个元素大于最左侧的元素 那么该元素处于前面的递增子数组
	 * 否则处于后边的递增子数组 以此调整左右指针指向的元素
	 */
	public int minNumberInRotateArray(int[] array)
	{
		if(array.length==0)
		{
			return 0;
		}
		int l=0;
		int r=array.length-1;
		/*
		 * 表述方式一
		 */
		while(l<r)
		{
			int m=(l+r)/2;//折半后的元素位置
			if(array[m]>array[r])//如果中间元素大于末尾元素 说明中间元素处于第一个递增序列 说明最小值在中间元素的右侧
			{
				l=m+1;
			}
			else//如果中间元素小于末尾元素 说明中间元素处于第二个递增序列 说明最小值在中间元素的左侧
			{
				r=m;
			}
		}
		//return array[l];
		
		/*
		 * 另一种表述方式
		 */
		int mid=l;
		while(array[l]>=array[r])
		{
			if(r-l==1)
			{
				mid=r;
				break;
			}
			mid=(l+r)/2;
			if(array[mid]>=array[l])
			{
				l=mid;
			}
			else if(array[mid]<=array[r])
			{
				r=mid;
			}
		}
		return array[mid];
	}
	/*
	 * 而如果数组元素允许重复的话 可能出现特殊情况为l、r、m三下标对应的元素相等
	 * 此时无法确定解在哪个区间 需要转换为顺序查找 在while中加入此判断和对应操作即可
	 */
}

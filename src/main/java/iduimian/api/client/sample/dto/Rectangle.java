package iduimian.api.client.sample.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 表示脸部,头部在图片位置的矩形类.<br />
 * 确定矩形使用的是 左上和右下2点.
 */
public class Rectangle implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 2811435334159720815L;

	/**
	 * 矩形左上角x坐标.
	 */
	private int left;
	/**
	 * 矩形左上角y坐标.
	 */
	private int top;
	/**
	 * 矩形右下角x坐标.
	 */
	private int right;
	/**
	 * 矩形右下角y坐标.
	 */
	private int bottom;

	public Rectangle() {
	}

	/**
	 * 构造函数，传入矩形4要素.
	 *
	 * @param left
	 *            - 左上角x坐标
	 * @param top
	 *            - 左上角y坐标
	 * @param right
	 *            - 右下角x坐标
	 * @param bottom
	 *            - 右下角y坐标
	 */
	public Rectangle(final int left, final int top, final int right, int bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}

	/**
	 * 得到左上角x坐标.
	 *
	 * @return 左上角x坐标
	 */
	public final int getLeft() {
		return left;
	}

	/**
	 * 设置左上角x坐标.
	 *
	 * @param left
	 *            - 左上角x坐标
	 */
	public final void setLeft(final int left) {
		this.left = left;
	}

	/**
	 * 得到左上角y坐标.
	 *
	 * @return 左上角y坐标
	 */
	public final int getTop() {
		return top;
	}

	/**
	 * 设置左上角y坐标.
	 *
	 * @param top
	 *            - 左上角y坐标
	 */
	public final void setTop(final int top) {
		this.top = top;
	}

	/**
	 * 得到右下角x坐标.
	 *
	 * @return 右下角x坐标
	 */
	public final int getRight() {
		return right;
	}

	/**
	 * 设置右下角x坐标.
	 *
	 * @param right
	 *            - 右下角x坐标
	 */
	public void setRight(int right) {
		this.right = right;
	}

	/**
	 * 得到右下角y坐标.
	 *
	 * @return 右下角y坐标
	 */
	public int getBottom() {
		return bottom;
	}

	/**
	 * 设置右下角y坐标.
	 *
	 * @param right
	 *            - 右下角y坐标
	 */
	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	@Override
	public final String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

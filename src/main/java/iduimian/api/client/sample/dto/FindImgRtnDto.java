package iduimian.api.client.sample.dto;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 创建照片库api所返回的对象
 */
public class FindImgRtnDto extends RtnDto {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8547414012190865731L;
	private List<Score> scores;


	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

package iduimian.api.client.sample.dto;

/**
 * 创建照片库api所返回的对象
 */
public class MatchRtnDto extends RtnDto {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -152389416725005215L;

    private float score;

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

}

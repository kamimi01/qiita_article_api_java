package qiita_article_dto;

import java.security.Timestamp;

public class Qiita_article_dto {
    
    // プロパティ
    private String title;
    private Timestamp updated_at;
    private int likes_count;
    
    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }
    /**
     * @param title セットする title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @return updated_at
     */
    public Timestamp getUpdated_at() {
        return updated_at;
    }
    /**
     * @param updated_at セットする updated_at
     */
    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
    /**
     * @return likes_count
     */
    public int getLikes_count() {
        return likes_count;
    }
    /**
     * @param likes_count セットする likes_count
     */
    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }
    
    

}

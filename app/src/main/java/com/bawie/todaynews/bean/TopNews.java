package com.bawie.todaynews.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Date：2017/4/11
 * author: 付智焱Administrator.
 * function：
 */
 @Table(name="TopNews")
public class TopNews {
    @Column(name="id",isId = true,autoGen = true,property = "NOT NULL")
    private int id;
    @Column(name="uri")
    private String uri;
    @Column(name="title")
    private String title;
    @Column(name="tag")
    private int tag;

    public TopNews() {
    }

    public TopNews(String uri, String title,int tag) {
        this.uri = uri;
        this.title = title;
        this.tag=tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "TopNews{" +
                "id=" + id +
                ", uri='" + uri + '\'' +
                ", title='" + title + '\'' +
                ", tag=" + tag +
                '}';
    }
}

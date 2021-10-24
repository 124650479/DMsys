package com.dmsys.demo.bean;

public class Form {
    int form_id;
    String title;
    String html;

    @Override
    public String toString() {
        return "Form{" +
                "form_id=" + form_id +
                ", title='" + title + '\'' +
                ", html='" + html + '\'' +
                '}';
    }

    public int getForm_id() {
        return form_id;
    }

    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}

package com.ztcly.shop.model;

public class Error {
    private String errortitle;
    private String errorinfo;
    private String nextpage;
    private String nextpagetitle;

    public String getNextpage() {
        return nextpage;
    }

    public void setNextpage(String nextpage) {
        this.nextpage = nextpage;
    }

    public String getNextpagetitle() {
        return nextpagetitle;
    }

    public void setNextpagetitle(String nextpagetitle) {
        this.nextpagetitle = nextpagetitle;
    }

    public String getErrortitle() {
        return errortitle;
    }

    public void setErrortitle(String errortitle) {
        this.errortitle = errortitle;
    }

    public String getErrorinfo() {
        return errorinfo;
    }

    public void setErrorinfo(String errorinfo) {
        this.errorinfo = errorinfo;
    }
}

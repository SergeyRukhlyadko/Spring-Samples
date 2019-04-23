package springt.annotation;

public class BasicBean {

    private CustomBean customBean;

    public BasicBean(CustomBean customBean) {
        this.customBean = customBean;
    }

    public CustomBean getCustomBean() {
        return customBean;
    }
}

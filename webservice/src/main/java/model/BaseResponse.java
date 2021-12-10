package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseResponse implements Serializable {
    List<ZoomLink> zoomLinkList = new ArrayList<>();

    public List<ZoomLink> getZoomLinkList() {
        return zoomLinkList;
    }

    public void setZoomLinkList(List<ZoomLink> zoomLinkList) {
        this.zoomLinkList = zoomLinkList;
    }
}

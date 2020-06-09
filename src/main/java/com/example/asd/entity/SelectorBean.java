package com.example.asd.entity;

import io.swagger.annotations.ApiModel;

import java.util.List;


@ApiModel(value = "选项卡对象模型")
public class SelectorBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * rowList : [{"rowId":1113,"title":"地址","rowOrder":"","sortOrder":"","listOfFilter":[{"text":"","value":"","checked":""}],"checked":true,"value":"","width":"300px"}]
         * id : 222
         * checked : false
         */

        private int id;
        private boolean checked;
        private List<RowListBean> rowList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public List<RowListBean> getRowList() {
            return rowList;
        }

        public void setRowList(List<RowListBean> rowList) {
            this.rowList = rowList;
        }

        public static class RowListBean {
            /**
             * rowId : 1113
             * title : 地址
             * rowOrder :
             * sortOrder :
             * listOfFilter : [{"text":"","value":"","checked":""}]
             * checked : true
             * value :
             * width : 300px
             */

            private int rowId;
            private String title;
            private String rowOrder;
            private String sortOrder;
            private boolean checked;
            private String value;
            private String width;
            private List<ListOfFilterBean> listOfFilter;

            public int getRowId() {
                return rowId;
            }

            public void setRowId(int rowId) {
                this.rowId = rowId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getRowOrder() {
                return rowOrder;
            }

            public void setRowOrder(String rowOrder) {
                this.rowOrder = rowOrder;
            }

            public String getSortOrder() {
                return sortOrder;
            }

            public void setSortOrder(String sortOrder) {
                this.sortOrder = sortOrder;
            }

            public boolean isChecked() {
                return checked;
            }

            public void setChecked(boolean checked) {
                this.checked = checked;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public List<ListOfFilterBean> getListOfFilter() {
                return listOfFilter;
            }

            public void setListOfFilter(List<ListOfFilterBean> listOfFilter) {
                this.listOfFilter = listOfFilter;
            }

            public static class ListOfFilterBean {
                /**
                 * text :
                 * value :
                 * checked :
                 */

                private String text;
                private String value;
                private boolean checked;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public boolean getChecked() {
                    return checked;
                }

                public void setChecked(boolean checked) {
                    this.checked = checked;
                }
            }
        }
    }

}

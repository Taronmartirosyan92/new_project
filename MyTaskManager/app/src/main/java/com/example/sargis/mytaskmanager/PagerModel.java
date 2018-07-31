package com.example.sargis.mytaskmanager;

class PagerModel {
    private String title;
    private String content;

    private PagerModel() {

    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public static Builder newBuilder() {
        return new PagerModel().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setTitle(String title) {
            PagerModel.this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            PagerModel.this.content = content;

            return this;
        }

        public PagerModel build() {
            return PagerModel.this;
        }

    }
}

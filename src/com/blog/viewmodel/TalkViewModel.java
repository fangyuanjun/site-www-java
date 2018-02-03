package com.blog.viewmodel;

import java.util.List;

import com.blog.entity.blog_tb_talk;

    public class TalkViewModel
    {
        /// <summary>
        /// 碎言碎语
        /// </summary>
        private List<blog_tb_talk> talkCollection;

		public List<blog_tb_talk> getTalkCollection() {
			return talkCollection;
		}

		public void setTalkCollection(List<blog_tb_talk> talkCollection) {
			this.talkCollection = talkCollection;
		}
    }

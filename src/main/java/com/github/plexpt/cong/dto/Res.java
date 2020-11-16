package com.github.plexpt.cong.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @email plexpt@gmail.com
 * @date 2020-11-13 14:37
 */
@NoArgsConstructor
@Data
public class Res {

   

    private boolean succeeded;
    private RespDataBean resp_data;

    @NoArgsConstructor
    @Data
    public static class RespDataBean {
        private List<TopicsBean> topics;

        @NoArgsConstructor
        @Data
        public static class TopicsBean {
          

            private long topic_id;
            private GroupBean group;
            private String type;
            private TaskBean task;
            private StatisticsBean statistics;
            private boolean enabled_task;
            private boolean show_solutions;
            private int likes_count;
            private int rewards_count;
            private int comments_count;
            private int reading_count;
            private int readers_count;
            private boolean digested;
            private boolean sticky;
            private String stick_time;
            private String create_time;
            private String modify_time;
            private UserSpecificBean user_specific;
            private TalkBean talk;
            private List<LatestLikesBean> latest_likes;
            private List<ShowCommentsBean> show_comments;
            private List<RewardsBean> rewards;

            @NoArgsConstructor
            @Data
            public static class GroupBean {
           

                private int group_id;
                private String name;
            }

            @NoArgsConstructor
            @Data
            public static class TaskBean {
    

                private OwnerBean owner;
                private String text;
                private String anonymous;

                @NoArgsConstructor
                @Data
                public static class OwnerBean {
              

                    private long user_id;
                    private String name;
                    private String alias;
                    private String avatar_url;
                    private String description;
                }
            }

            @NoArgsConstructor
            @Data
            public static class StatisticsBean {
            

                private int submitted_count;
            }

            @NoArgsConstructor
            @Data
            public static class UserSpecificBean {
             
                private boolean liked;
                private boolean subscribed;
                private boolean submitted;
            }

            @NoArgsConstructor
            @Data
            public static class TalkBean {
             
               

                private OwnerBeanX owner;
                private String text;

                @NoArgsConstructor
                @Data
                public static class OwnerBeanX {
                 

                    private long user_id;
                    private String name;
                    private String avatar_url;
                }
            }

            @NoArgsConstructor
            @Data
            public static class LatestLikesBean {
            

                private String create_time;
                private OwnerBeanXX owner;

                @NoArgsConstructor
                @Data
                public static class OwnerBeanXX {
                 

                    private long user_id;
                    private String name;
                    private String avatar_url;
                    private int number;
                }
            }

            @NoArgsConstructor
            @Data
            public static class ShowCommentsBean {
                

                private long comment_id;
                private String create_time;
                private OwnerBeanXXX owner;
                private String text;
                private int likes_count;
                private int rewards_count;
                private int replies_count;
                private long parent_comment_id;
                private ReplieeBean repliee;

                @NoArgsConstructor
                @Data
                public static class OwnerBeanXXX {
               
                    private long user_id;
                    private String name;
                    private String avatar_url;
                }

                @NoArgsConstructor
                @Data
                public static class ReplieeBean {
             

                    private long user_id;
                    private String name;
                    private String avatar_url;
                }
            }

            @NoArgsConstructor
            @Data
            public static class RewardsBean {
 

                private String create_time;
                private OwnerBeanXXXX owner;
                private int amount;

                @NoArgsConstructor
                @Data
                public static class OwnerBeanXXXX {
        

                    private long user_id;
                    private String name;
                    private String alias;
                    private String avatar_url;
                    private String description;
                }
            }
        }
    }
}

package com.github.plexpt.cong.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @email plexpt@gmail.com
 * @date 2020-11-13 15:33
 */
@NoArgsConstructor
@Data
public class DownloadDTO {
 
    private boolean succeeded;
    private RespDataBean resp_data;

    @NoArgsConstructor
    @Data
    public static class RespDataBean {
 

        private String download_url;
    }
}

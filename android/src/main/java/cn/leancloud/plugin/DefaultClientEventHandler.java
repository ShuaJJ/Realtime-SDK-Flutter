package cn.leancloud.plugin;

import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMClientEventHandler;

public class DefaultClientEventHandler extends AVIMClientEventHandler {
  private ClientStatusListener listener;

  public DefaultClientEventHandler(ClientStatusListener listener) {
    this.listener = listener;
  }

  /**
   * 实现本方法以处理网络断开事件
   *
   * @param client
   * @since 3.0
   */
  public void onConnectionPaused(AVIMClient client) {
    if (null != this.listener) {
      this.listener.onDisconnected(client);
    }
  }

  /**
   * 实现本方法以处理网络恢复事件
   *
   * @since 3.0
   * @param client
   */

  public void onConnectionResume(AVIMClient client) {
    if (null != this.listener) {
      this.listener.onResumed(client);
    }
  }

  /**
   * 实现本方法以处理当前登录被踢下线的情况
   *
   *
   * @param client
   * @param code 状态码说明被踢下线的具体原因
   */

  public void onClientOffline(AVIMClient client, int code) {
    if (null != this.listener) {
      this.listener.onOffline(client, code);
    }
  }
}

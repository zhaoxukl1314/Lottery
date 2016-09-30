package com.example.zhaoxu.lottery.Utils;

import com.example.zhaoxu.lottery.Contant.ConstantValue;
import com.example.zhaoxu.lottery.Info.GlobalParams;

import org.apache.commons.codec.Encoder;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2016/9/19.
 */
public class HttpClientUtils {

    private HttpClient mHttpClient;
    private HttpGet mHttpGet;
    private HttpPost mHttpPost;

    public HttpClientUtils() {
        mHttpClient = new DefaultHttpClient();
        if (StringUtils.isNotBlank(GlobalParams.PROXY)) {
            HttpHost httpHost = new HttpHost(GlobalParams.PROXY,GlobalParams.PORT);
            mHttpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,httpHost);
        }
    }

    public InputStream sendXml(String uri, String xml) {
        mHttpPost = new HttpPost(uri);
        StringEntity entity = null;
        try {
            entity = new StringEntity(xml, ConstantValue.ENCONDING);
            mHttpPost.setEntity(entity);
            HttpResponse response = mHttpClient.execute(mHttpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                return response.getEntity().getContent();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

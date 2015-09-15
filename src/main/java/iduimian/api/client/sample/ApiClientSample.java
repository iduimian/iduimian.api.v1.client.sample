package iduimian.api.client.sample;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import iduimian.api.client.sample.dto.CreateLibRtnDto;
import iduimian.api.client.sample.dto.DeleteImgRtnDto;
import iduimian.api.client.sample.dto.DeleteLibRtnDto;
import iduimian.api.client.sample.dto.DetectRtnDto;
import iduimian.api.client.sample.dto.FindImgRtnDto;
import iduimian.api.client.sample.dto.LibStatusRtnDto;
import iduimian.api.client.sample.dto.MatchRtnDto;
import iduimian.api.client.sample.dto.RegistImgRtnDto;
import iduimian.api.client.sample.utils.JsonMapper;

public class ApiClientSample {

    private static final String SECRET_KEY = "OxiMx6hy";
    private static final String USER_ID = "iZfiQGl4Tnqqooussvvuvn";
    private static Logger logger = LoggerFactory.getLogger(ApiClientSample.class);
    private static final String BASE_URL = "http://iduimian.com/api/v1";

    /**
     * lib/create: 创建照片库
     *
     * @param libName
     */
    public CreateLibRtnDto createLib(String libName) {
        logger.debug("创建照片库 start");
        CreateLibRtnDto dto = null;
        try {

            final CloseableHttpClient client = HttpClients.createDefault();
            final HttpPost httpPost = new HttpPost(BASE_URL + "/lib/create");

            // basic 认证，使用分配的用户身份ID 和 密码
            // new UsernamePasswordCredentials(partner_id, secret_key);
            final UsernamePasswordCredentials creds = new UsernamePasswordCredentials(USER_ID, SECRET_KEY);

            httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));

            final List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("lib_name", libName));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            final CloseableHttpResponse response = client.execute(httpPost);
            logger.debug("get response is {}", response);

            if (response.getStatusLine().getStatusCode() == 200) {
                final String value = EntityUtils.toString(response.getEntity());
                logger.debug("get response body is {}", value);

                final JsonMapper jsonMapper = JsonMapper.nonEmptyMapper();
                dto = jsonMapper.fromJson(value, CreateLibRtnDto.class);
                logger.debug("get response dto is {}", dto);
            }
            client.close();
        } catch (final AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug("创建照片库 end");
        return dto;
    }

    /**
     * lib/delete: 删除照片库
     *
     * @param libName
     */
    public DeleteLibRtnDto deleteLib(String libName) {
        logger.debug("删除照片库 start");
        DeleteLibRtnDto dto = null;
        try {

            final CloseableHttpClient client = HttpClients.createDefault();
            final HttpPost httpPost = new HttpPost(BASE_URL + "/lib/delete");

            // basic 认证，使用分配的用户身份ID 和 密码
            // new UsernamePasswordCredentials(partner_id, secret_key);
            final UsernamePasswordCredentials creds = new UsernamePasswordCredentials(USER_ID, SECRET_KEY);

            httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));

            final List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("lib_name", libName));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            final CloseableHttpResponse response = client.execute(httpPost);
            logger.debug("get response is {}", response);
            if (response.getStatusLine().getStatusCode() == 200) {
                final String value = EntityUtils.toString(response.getEntity());
                logger.debug("get response body is {}", value);

                final JsonMapper jsonMapper = JsonMapper.nonEmptyMapper();
                dto = jsonMapper.fromJson(value, DeleteLibRtnDto.class);
                logger.debug("get response dto is {}", dto);
            }

            client.close();
        } catch (final AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug("删除照片库 end");
        return dto;
    }



    /**
     * lib/status：获知照片库状态（容量）
     *
     * @param libName
     */
    public LibStatusRtnDto getLibStatus(String libName) {
        logger.debug("获知照片库状态（容量） start");
        LibStatusRtnDto dto = null;
        try {

            final CloseableHttpClient client = HttpClients.createDefault();
            final HttpPost httpPost = new HttpPost(BASE_URL + "/lib/status");

            // basic 认证，使用分配的用户身份ID 和 密码
            // new UsernamePasswordCredentials(partner_id, secret_key);
            final UsernamePasswordCredentials creds = new UsernamePasswordCredentials(USER_ID, SECRET_KEY);

            httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));

            final List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("lib_name", libName));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            final CloseableHttpResponse response = client.execute(httpPost);
            logger.debug("get response is {}", response);
            if (response.getStatusLine().getStatusCode() == 200) {
                final String value = EntityUtils.toString(response.getEntity());
                logger.debug("get response body is {}", value);

                final JsonMapper jsonMapper = JsonMapper.nonEmptyMapper();
                dto = jsonMapper.fromJson(value, LibStatusRtnDto.class);
                logger.debug("get response dto is {}", dto);
            }

            client.close();
        } catch (final AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug("获知照片库状态（容量） end");
        return dto;
    }

    /**
     * image/regist：加入照片到照片库
     *
     * @param libName
     */
    public RegistImgRtnDto registImg(String libName, File image) {
        logger.debug("加入照片到照片库 start");
        RegistImgRtnDto dto = null;
        try {

            final CloseableHttpClient client = HttpClients.createDefault();
            final HttpPost httpPost = new HttpPost(BASE_URL + "/image/regist");

            // basic 认证，使用分配的用户身份ID 和 密码
            // new UsernamePasswordCredentials(partner_id, secret_key);
            final UsernamePasswordCredentials creds = new UsernamePasswordCredentials(USER_ID, SECRET_KEY);

            httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));

            final MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addTextBody("lib_name", libName);
            builder.addBinaryBody("img_file", image, ContentType.APPLICATION_OCTET_STREAM, image.getName());

            final HttpEntity multipart = builder.build();
            httpPost.setEntity(multipart);

            final CloseableHttpResponse response = client.execute(httpPost);
            logger.debug("get response is {}", response);
            if (response.getStatusLine().getStatusCode() == 200) {
                final String value = EntityUtils.toString(response.getEntity());
                logger.debug("get response body is {}", value);

                final JsonMapper jsonMapper = JsonMapper.nonEmptyMapper();
                dto = jsonMapper.fromJson(value, RegistImgRtnDto.class);
                logger.debug("get response dto is {}", dto);
            }

            client.close();
        } catch (final AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug("加入照片到照片库 end");
        return dto;
    }

    /**
     * image/find：查找相似照片
     *
     * @param libName
     * @param image
     */
    public FindImgRtnDto findImg(String libName, File image) {
        logger.debug("查找相似照片 start");
        FindImgRtnDto dto = null;
        try {

            final CloseableHttpClient client = HttpClients.createDefault();
            final HttpPost httpPost = new HttpPost(BASE_URL + "/image/find");

            // basic 认证，使用分配的用户身份ID 和 密码
            // new UsernamePasswordCredentials(partner_id, secret_key);
            final UsernamePasswordCredentials creds = new UsernamePasswordCredentials(USER_ID, SECRET_KEY);

            httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));

            final MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addTextBody("lib_name", libName);
            builder.addBinaryBody("img_file", image, ContentType.APPLICATION_OCTET_STREAM, image.getName());
            builder.addTextBody("face_index", "0");

            final HttpEntity multipart = builder.build();
            httpPost.setEntity(multipart);

            final CloseableHttpResponse response = client.execute(httpPost);
            logger.debug("get response is {}", response);
            if (response.getStatusLine().getStatusCode() == 200) {
                final String value = EntityUtils.toString(response.getEntity());
                logger.debug("get response body is {}", value);

                final JsonMapper jsonMapper = JsonMapper.nonEmptyMapper();
                dto = jsonMapper.fromJson(value, FindImgRtnDto.class);
                logger.debug("get response dto is {}", dto);
            }

            client.close();
        } catch (final AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        logger.debug("查找相似照片 end");
        return dto;
    }


    /**
     * image/match：匹配2张照片的相似度
     *
     * @param libName
     * @param image
     */
    public MatchRtnDto matchImg(File image1, File image2) {
        logger.debug("匹配2张照片的相似度 start");
        MatchRtnDto dto = null;
        try {

            final CloseableHttpClient client = HttpClients.createDefault();
            final HttpPost httpPost = new HttpPost(BASE_URL + "/image/match");

            // basic 认证，使用分配的用户身份ID 和 密码
            // new UsernamePasswordCredentials(partner_id, secret_key);
            final UsernamePasswordCredentials creds = new UsernamePasswordCredentials(USER_ID, SECRET_KEY);

            httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));

            final MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody("img_file1", image1, ContentType.APPLICATION_OCTET_STREAM, image1.getName());
            builder.addBinaryBody("img_file2", image2, ContentType.APPLICATION_OCTET_STREAM, image2.getName());

            final HttpEntity multipart = builder.build();
            httpPost.setEntity(multipart);

            final CloseableHttpResponse response = client.execute(httpPost);
            logger.debug("get response is {}", response);
            if (response.getStatusLine().getStatusCode() == 200) {
                final String value = EntityUtils.toString(response.getEntity());
                logger.debug("get response body is {}", value);

                final JsonMapper jsonMapper = JsonMapper.nonEmptyMapper();
                dto = jsonMapper.fromJson(value, MatchRtnDto.class);
                logger.debug("get response dto is {}", dto);
            }

            client.close();
        } catch (final AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        logger.debug("匹配2张照片的相似度 end");
        return dto;
    }

    /**
     * image/detect：检测照片中头脸部区域
     *
     * @param libName
     * @param image
     */
    public DetectRtnDto detectImg(File image) {
        logger.debug("检测照片中头脸部区域 start");
        DetectRtnDto dto = null;
        try {

            final CloseableHttpClient client = HttpClients.createDefault();
            final HttpPost httpPost = new HttpPost(BASE_URL + "/image/detect");

            // basic 认证，使用分配的用户身份ID 和 密码
            // new UsernamePasswordCredentials(partner_id, secret_key);
            final UsernamePasswordCredentials creds = new UsernamePasswordCredentials(USER_ID, SECRET_KEY);

            httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));

            final MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody("img_file", image, ContentType.APPLICATION_OCTET_STREAM, image.getName());

            final HttpEntity multipart = builder.build();
            httpPost.setEntity(multipart);

            final CloseableHttpResponse response = client.execute(httpPost);
            logger.debug("get response is {}", response);
            if (response.getStatusLine().getStatusCode() == 200) {
                final String value = EntityUtils.toString(response.getEntity());
                logger.debug("get response body is {}", value);

                final JsonMapper jsonMapper = JsonMapper.nonEmptyMapper();
                dto = jsonMapper.fromJson(value, DetectRtnDto.class);
                logger.debug("get response dto is {}", dto);
            }

            client.close();
        } catch (final AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        logger.debug("检测照片中头脸部区域 end");
        return dto;
    }


    /**
     * image/delete: 删除照片库中的照片
     *
     * @param libName
     * @param imgId
     */
    public DeleteImgRtnDto deleteImg(String libName, String imgId) {
        logger.debug("删除照片库中的照片 start");
        DeleteImgRtnDto dto = null;
        try {

            final CloseableHttpClient client = HttpClients.createDefault();
            final HttpPost httpPost = new HttpPost(BASE_URL + "/image/delete");

            // basic 认证，使用分配的用户身份ID 和 密码
            // new UsernamePasswordCredentials(partner_id, secret_key);
            final UsernamePasswordCredentials creds = new UsernamePasswordCredentials(USER_ID, SECRET_KEY);

            httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));

            final List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("lib_name", libName));
            params.add(new BasicNameValuePair("img_id", imgId));

            httpPost.setEntity(new UrlEncodedFormEntity(params));
            final CloseableHttpResponse response = client.execute(httpPost);
            logger.debug("get response is {}", response);
            if (response.getStatusLine().getStatusCode() == 200) {
                final String value = EntityUtils.toString(response.getEntity());
                logger.debug("get response body is {}", value);

                final JsonMapper jsonMapper = JsonMapper.nonEmptyMapper();
                dto = jsonMapper.fromJson(value, DeleteImgRtnDto.class);
                logger.debug("get response dto is {}", dto);
            }

            client.close();
        } catch (final AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug("删除照片库中的照片 end");
        return dto;
    }

}

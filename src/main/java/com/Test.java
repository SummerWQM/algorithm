package com;


import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * 采用监权方式1： 签名原文串的拼接规则为: 请求方法 + 请求主机 +请求路径 + ? + 请求字符串
 */
public class Test {

    //  private static String apiDomain = "cvm.yunapi3.yf-m17.tcecqpoc.fsphere.cn";    //根据实际接口调整

    private static String apiDomain = "dcos.yunapi3.yf-m17.tcecqpoc.fsphere.cn";

    public static void main(String[] args) throws Exception {
        TreeMap<String, Object> params = new TreeMap<String, Object>(); // TreeMap可以自动排序
        // 实际调用时应当使用随机数，例如：params.put("Nonce", new Random().nextInt(java.lang.Integer.MAX_VALUE));
        params.put("Nonce", new Random().nextInt(java.lang.Integer.MAX_VALUE)); // 公共参数
        // 实际调用时应当使用系统当前时间，例如：   params.put("Timestamp", System.currentTimeMillis() / 1000);
        params.put("Timestamp", System.currentTimeMillis() / 1000); // 公共参数
        params.put("SecretId", "AKID7Pp76H9Kh0SO4Mr0RD6Bh3REVAkaWNnf"); // 公共参数
        params.put("Action", "DescribeIdcInfoEx"); // 公共参数
        params.put("Version", "2020-04-21"); // 公共参数
        params.put("Offset", 0); // 公共参数
        params.put("Limit", 20); // 公共参数
        params.put("Scheme", "idc"); // 公共参数
        params.put("SystemKey", "web"); // 公共参数
        params.put("SystemId", "web"); // 公共参数
        params.put("Op", "query"); // 公共参数
        params.put("FieldFilters", "export_device,id"); // 公共参数
        params.put("RoughItem", "id"); // 公共参数
        params.put("Region", "shanghai"); // 公共参数
//        HashMap filter = new HashMap();
//        filter.put("Name", "zone");
//        ArrayList v = new ArrayList();
//        filter.put("Values", Collections.singletonList("ap-guangzhou-1"));
//        ArrayList filters = new ArrayList();
//        HashMap
//        filters.add(filter);
        params.put("Filters.0.Name", "ZoneName"); // 公共参数
        params.put("Filters.0.Values.0", "");

//        params.put("XX", "XXX"); // 业务相关参数
        params.put("Signature", sign(getStringToSign(params), "YCoc4AVCud6H4Pt08IUHo7SHYGi17Kr7", "HmacSHA1")); // 公共参数
        String url = getUrl(params);
        System.out.println(url);
        openURL(url);
        // https://cvm.yunapi3.yf-m17.tcepoc.fsphere.cn/?Action=DescribeInstances&InstanceIds.0=ins-09dx96dg&Limit=20&Nonce=816916887&Offset=0&Region=ap-guangzhou&SecretId=AKID7Pp76H9Kh0SO4Mr0RD6Bh3REVAkaWNnf&Signature=FD1U3Cdnf2Osm%2Bp2uRR4DAjwoWY%3D&Timestamp=1616571697&Version=2017-03-12
    }


    public static String sign(String s, String key, String method) throws Exception {
        Mac mac = Mac.getInstance(method);


        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(CHARSET), mac.getAlgorithm());
        mac.init(secretKeySpec);
        byte[] hash = mac.doFinal(s.getBytes(CHARSET));
        return DatatypeConverter.printBase64Binary(hash);
    }

    public static String getStringToSign(TreeMap<String, Object> params) {
//        StringBuilder s2s = new StringBuilder("GETcvm.api3.yf-1.tcepoc.fsphere.cn/?");
        StringBuilder s2s = new StringBuilder("GET" + apiDomain + "/?");
        // 签名时要求对参数进行字典排序，此处用TreeMap保证顺序
        for (String k : params.keySet()) {
            s2s.append(k).append("=").append(params.get(k).toString()).append("&");
        }
        return s2s.toString().substring(0, s2s.length() - 1);
    }

    public static String getUrl(TreeMap<String, Object> params) throws UnsupportedEncodingException {
        StringBuilder url = new StringBuilder("http://" + apiDomain + "/?");

        // 实际请求的url中对参数顺序没有要求
        for (String k : params.keySet()) {
            // 需要对请求串进行urlencode，由于key都是英文字母，故此处仅对其value进行urlencode
            url.append(k).append("=").append(URLEncoder.encode(params.get(k).toString(), CHARSET)).append("&");
        }

        return url.toString().substring(0, url.length() - 1);
    }

//    public static void main(String[] args) throws Exception {
//        TreeMap<String, Object> params = new TreeMap<String, Object>(); // TreeMap可以自动排序
//        // 实际调用时应当使用随机数，例如：params.put("Nonce", new Random().nextInt(java.lang.Integer.MAX_VALUE));
//        params.put("Nonce", new Random().nextInt(java.lang.Integer.MAX_VALUE)); // 公共参数
//        // 实际调用时应当使用系统当前时间，例如：   params.put("Timestamp", System.currentTimeMillis() / 1000);
//        params.put("Timestamp", System.currentTimeMillis() / 1000); // 公共参数
//        params.put("SecretId", "AKID7Pp76H9Kh0SO4Mr0RD6Bh3REVAkaWNnf"); // 公共参数
//        params.put("Action", "DescribeInstances"); // 公共参数
//        params.put("Version", "2017-03-12"); // 公共参数
//        params.put("Region", "ap-guangzhou"); // 公共参数
//        params.put("Limit", 20); // 业务参数
//        params.put("Offset", 0); // 业务参数
//        params.put("InstanceIds.0", "ins-09dx96dg"); // 业务参数
//        params.put("Signature", sign(getStringToSign(params), "YCoc4AVCud6H4Pt08IUHo7SHYGi17Kr7", "HmacSHA1")); // 公共参数
//        System.out.println(getUrl(params));
//    }

    private final static String CHARSET = "UTF-8";

    public static void openURL(String url) {
        try {
            browse(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void browse(String url) throws Exception {
        //获取操作系统的名字
        String osName = System.getProperty("os.name", "");
        if (osName.startsWith("Mac OS")) {
            //苹果的打开方式
            Class fileMgr = Class.forName("com.apple.eio.FileManager");
            Method openURL = fileMgr.getDeclaredMethod("openURL", new Class[]{String.class});
            openURL.invoke(null, new Object[]{url});
        } else if (osName.startsWith("Windows")) {
            //windows的打开方式。
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        } else {
            // Unix or Linux的打开方式
            String[] browsers = {"firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape"};
            String browser = null;
            for (int count = 0; count < browsers.length && browser == null; count++)
                //执行代码，在brower有值后跳出，
                //这里是如果进程创建成功了，==0是表示正常结束。
                if (Runtime.getRuntime().exec(new String[]{"which", browsers[count]}).waitFor() == 0)
                    browser = browsers[count];
            if (browser == null)
                throw new Exception("Could not find web browser");
            else
                //这个值在上面已经成功的得到了一个进程。
                Runtime.getRuntime().exec(new String[]{browser, url});
        }
    }
}



package qiita_article;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class QiitaList {

    public static void main(String[] args) {
        // 接続するエンドポイント
        String getUrl = "https://qiita.com/api/v2/users/kamimi01";
        try {
            URL url = new URL(getUrl);

            // connectionのインスタンス 
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // メソッドの指定
            connection.setRequestMethod("GET");
            
            // 通信開始
            connection.connect();
            
            // レスポンスコードを取得
            int responseCode = connection.getResponseCode();
            
            // 通信結果の判断
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 通信に成功
                InputStream in = connection.getInputStream();
                String encoding = connection.getContentEncoding();
                if (encoding == null) {
                    encoding = "UTF-8";
                }
                StringBuffer result = new StringBuffer();
                final InputStreamReader inReader = new InputStreamReader(in, encoding);
                final BufferedReader bufReader = new BufferedReader(inReader);
                
                String line = null;
                
                // 一行ずつテキストを読み込む
                while ((line = bufReader.readLine()) != null) {
                    result.append(line);
                }
                
                // クローズ
                bufReader.close();
                inReader.close();
                in.close();
                
                // アウトプット
                System.out.println("result==========:\n" + result);
                System.out.println(result instanceof Object);
            }
            
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

    }

}

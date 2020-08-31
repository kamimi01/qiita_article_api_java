package qiita_article;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import qiita_article_dto.Qiita_article_dto;

public class QiitaList {

    public static void main(String[] args) {
        
        // dtoを取得する
        Qiita_article_dto qiita_article_dto = new Qiita_article_dto();
        qiita_article_dto.setLikes_count(1);
        System.out.println("ライクの数：" + qiita_article_dto.getLikes_count());
        
        // 接続するエンドポイント
        String getUrl = "https://qiita.com/api/v2/items?page=1&per_page=10&query=qiita+user%3AQiita";
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

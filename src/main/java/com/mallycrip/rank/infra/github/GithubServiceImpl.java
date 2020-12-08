package com.mallycrip.rank.infra.github;

import com.mallycrip.rank.domain.entity.Contributions;
import com.mallycrip.rank.exception.NotFoundException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class GithubServiceImpl implements GithubService {
    @Override
    public Long getContributions(String githubId) {
        try {
            Document doc = Jsoup.connect(
                    "https://github.com/users/" + githubId + "/contributions").get();
            Elements elements = doc.select("html body div div h2");
            return Long.valueOf(elements.get(0).text().replaceAll("[^0-9]", ""));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0L;
        }
    }

    @Override
    public String getImageUrl(String githubId) {
        try {
            String json = Jsoup.connect(
                    "https://api.github.com/users/"+githubId).ignoreContentType(true).execute().body();
            JSONObject jObject = new JSONObject(json);
            return jObject.getString("avatar_url");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg";
        }
    }
}

package com.mallycrip.rank.infra.github;

import com.mallycrip.rank.domain.entity.Contributions;
import com.mallycrip.rank.exception.NotFoundException;
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
        } catch (Exception e) { throw new NotFoundException(); }
    }
}

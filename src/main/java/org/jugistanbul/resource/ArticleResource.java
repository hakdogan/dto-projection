package org.jugistanbul.resource;

import org.jugistanbul.dto.ShortArticleInfo;
import org.jugistanbul.entity.Article;
import org.jugistanbul.service.ArticleService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author hakdogan (huseyin.akdogan@patikaglobal.com)
 * Created on 17.07.2022
 ***/

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class ArticleResource
{
    final ArticleService service;

    public ArticleResource(ArticleService service) {
        this.service = service;
    }

    @GET
    @Path("/allArticles")
    public List<ShortArticleInfo> fetchAllShortInfo(){
        return service.fetchAllArticlesInfo();
    }

    @GET
    @Path("/findArticleById/{id}")
    public ShortArticleInfo findArticleById(@PathParam("id") Long id){
        return service.findArticleById(id);
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Article savePost(final ShortArticleInfo article){
        return service.saveArticle(article);
    }
}

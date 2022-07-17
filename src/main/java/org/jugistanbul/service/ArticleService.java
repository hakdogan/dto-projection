package org.jugistanbul.service;

import org.jugistanbul.dto.ShortArticleInfo;
import org.jugistanbul.entity.Article;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author hakdogan (huseyin.akdogan@patikaglobal.com)
 * Created on 17.07.2022
 ***/
@ApplicationScoped
public class ArticleService
{
    final EntityManager entityManager;

    public ArticleService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<ShortArticleInfo> fetchAllArticlesInfo(){

        return entityManager.createQuery("""
            select
                new org.jugistanbul.dto.ShortArticleInfo (
                    a.title,
                    a.author)
            from Article  a
            """, ShortArticleInfo.class).getResultList();
    }

    public ShortArticleInfo findArticleById(final Long id){

        return entityManager.createQuery("""
            select
                new org.jugistanbul.dto.ShortArticleInfo (
                    a.title,
                    a.author)
            from Article a 
            where a.id = :id
            """, ShortArticleInfo.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    public Article saveArticle(final ShortArticleInfo article){
        var entity = new Article(article.title(), article.author(), LocalDateTime.now());
        entityManager.persist(entity);
        return entity;
    }
}

# DTO Projections
This repository shows you how to use Java Records as DTO Projections.

```java
    
    public record ShortArticleInfo(String title, String author)
    { }

    public List<ShortArticleInfo> fetchAllArticlesInfo(){

        return entityManager.createQuery("""
            select
                new org.jugistanbul.dto.ShortArticleInfo (
                    a.title,
                    a.author)
            from Article  a
            """, ShortArticleInfo.class).getResultList();
    }
```

## Requirements

- JDK 15 or later
- Docker(for quarkus dev services)


# my_blog_app
rest api


# master 브런치는 초기상태로 유지한다.

# 각 기능은 모듈별로 브런치를 blog브런치에서 checkout 하여 병합 후 최종 개발 완료된 모듈을 blog 브런치에 merge 시킨다.

아래와 같은 순서를 따른다.

1] 프로잭트 생성
2] blog 브런치 생성

3] 모듈 개발시 blog 브런치에서 해당 모듈 브런치로 checkout 
 
   [[ blog(head) ]] =>  [[ checkout -b 모듈명 ]]  => [[ 기능 개발 완료 ]] => PR 확인 후 blog 브런치에 merge
   

-- 코드를 입력하세요
select name
from(SELECT rownum, name
    FROM ANIMAL_INS
    order by datetime)
where rownum = 1
;
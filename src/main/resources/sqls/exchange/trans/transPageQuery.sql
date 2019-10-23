select t.*, a1.name as source_name, a1.cardno as source_card, a2.name as target_name, a2.cardno as target_card
from trans_record t
         left join account a1 on t.source_gid = a1.gid
         left join account a2 on t.target_gid = a2.gid
where a1.name = '#(xm)'
   or a2.name = '#(xm)'
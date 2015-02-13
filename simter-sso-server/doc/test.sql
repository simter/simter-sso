-- 登录验证
select case t.status_ = 1 when true then (
	case t.data_ = '0192023a7bbd73250516f069df18b500' when true then 'OK' else '密码错误' end
) else '帐号未激活' end
from (
	select a.status_, t.data_ from ST_SSO_ACCOUNT a
	inner join ST_SSO_AUTH t on t.pid = a.id
	where a.status_ = 1
	and (
		a.code_ = 'admin@simter.org1' 
		or exists (select 0 from ST_SSO_BIND b where b.pid = a.id and b.code_ = 'admin@simter.org1')
	)
) t;

  
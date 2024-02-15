SELECT 
    s,
    n,
    REPEAT(s, n)::TEXT AS res
FROM 
    repeatstr;

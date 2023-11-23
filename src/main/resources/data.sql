INSERT INTO dailydata.`user`
(created_date, modified_date, email, id, info, name, password)
VALUES(now(), now(), 'abab', 'abab', 'abab', 'abab', 'abab');

INSERT INTO dailydata.`main_count_dashboard` 
(today_sns_analysis_count, today_sns_analysis_ratio, today_sns_count, total_sns_analysis_count, total_sns_analysis_ratio, total_sns_count, created_date, modified_date, seq, category)
VALUES(31527, 93, 16243, 283257, 99, 315275, now(), now(), 0, 'none');
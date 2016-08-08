 
    function getTime() {  
        var mon, week, now, hour, min, ampm, time, str, tz, end, beg, sec;  
        /*  
        mon = new Array("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",  
                "Sep", "Oct", "Nov", "Dec");  
        */  
        mon = new Array("一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月",  
                "九月", "十月", "十一月", "十二月");  
        /*  
        day = new Array("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");  
        */  
        week = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");  
        now = new Date();  
        hour = now.getHours();  
        min = now.getMinutes();  
        sec = now.getSeconds();  
        if (hour < 10) {  
            hour = "0" + hour;  
        }  
        if (min < 10) {  
            min = "0" + min;  
        }  
        if (sec < 10) {  
            sec = "0" + sec;  
        }  
        $("#timer").html(  
                "<nobr>" + now.getFullYear() + "年" + now.getMonth() + "月" + + now.getDate() + "日,	"
                		 + week[now.getDay()] + "	"
                		 + hour + ":" + min + ":" + sec + "</nobr>");  
  
    }  
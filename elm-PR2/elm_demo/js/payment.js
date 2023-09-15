window.onload = function(){
	//获取显示隐藏按钮DOM对象
	let showBtn = document.getElementById('showBtn');
	
	let showZFB = document.getElementById('showZFB');
	let showWX = document.getElementById('showWX');
	let selZFB = document.getElementById('selZFB');
	let selWX = document.getElementById('selWX');
	//获取订单明细DOM对象
	let detailetBox =document.getElementById('detailetBox');
	//设置默认订单明细隐藏
	detailetBox.style.display='none';
	
	showZFB.style.display='block';
	showWX.style.display='none';
	
	showBtn.onclick = function(){
		//判断订单明细DOM对象是否隐藏，如果是就显示，否则就隐藏
		if(detailetBox.style.display=='none'){
			detailetBox.style.display='block';
		}else{
			detailetBox.style.display='none';
		}
	}
	
	selZFB.onclick = function(){
			//判断订单明细DOM对象是否隐藏，如果是就显示，否则就隐藏
			if(showZFB.style.display=='none'){
				showZFB.style.display='block';
				showWX.style.display='none';
			}
	}
	
	selWX.onclick = function(){
			//判断订单明细DOM对象是否隐藏，如果是就显示，否则就隐藏
			if(showWX.style.display=='none'){
					showZFB.style.display='none';
					showWX.style.display='block';
			}
		}
}

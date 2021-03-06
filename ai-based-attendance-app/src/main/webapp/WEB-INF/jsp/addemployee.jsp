<script>
	// Put event listeners into place
	window
			.addEventListener(
					"DOMContentLoaded",
					function() {
						// Grab elements, create settings, etc.
						var canvas = document.getElementById("canvas"), context = canvas
								.getContext("2d"), video = document
								.getElementById("video"), videoObj = {
							"video" : true
						}, errBack = function(error) {
							console.log("Video capture error: ", error.code);
						};

						// Put video listeners into place
						if (navigator.getUserMedia) { // Standard
							navigator.getUserMedia(videoObj, function(stream) {
								video.src = stream;
								video.play();
							}, errBack);
						} else if (navigator.webkitGetUserMedia) { // WebKit-prefixed
							navigator.webkitGetUserMedia(videoObj, function(
									stream) {
								video.src = window.webkitURL
										.createObjectURL(stream);
								video.play();
							}, errBack);
						} else if (navigator.mozGetUserMedia) { // WebKit-prefixed
							navigator.mozGetUserMedia(videoObj,
									function(stream) {
										video.src = window.URL
												.createObjectURL(stream);
										video.play();
									}, errBack);
						}

						// Trigger photo take
						document
								.getElementById("snap")
								.addEventListener(
										"click",
										function() {
											context.drawImage(video, 0, 0, 213,
													160);
											document
													.getElementById('canvasImg').src = canvas
													.toDataURL("image/png");

											//                    document.getElementById('video').style.display = "none";  // hide the live image video portin after click on take picture
										});

					}, false);
</script>

<h1>Capture Image using Camera!</h1>

<!--
     Ideally these elements aren't created until it's confirmed that the 
     client supports video/camera, but for the sake of illustrating the 
     elements involved, they are created with markup (not JavaScript)
    -->
<video id="video" width="213" height="160" autoplay></video>
<button id="snap">Capture Photo</button>

<form action="savetesting.jsp" method="post">
	<canvas id="canvas" width="213" height="160" name="ImageFile1"
		style="display: none;"></canvas>

	<img id="canvasImg" name="ImageFile"><img> <input
		type="reset" value="Reset" /> <input type="submit" value="Submit" />

</form>


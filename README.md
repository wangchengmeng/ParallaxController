# ParallaxController
Parallax

##该控制器是对RecycleView上下滑动使ImageView出现视差的效果


####演示

![icon](parallax.gif)

####中间大图会随着上下的滑动跟着滑动，但是不会画出边界

####ParallaxController

	创建一个ParallaxController	
    private ParallaxViewController mController = new ParallaxViewController();

	将图片添加到控制器中
    mController.imageParallax(mIvCover);

	//设置偏移量明显的程度  值越大 偏移量越明显
    int PARALLAX_SPEED = 200;
s3eAndroidUserActivity
======================

This is a very lightweight extension that makes it easier to have multiple
other extensions that each extend the main activity.

If creating an extension, you need to design it to use s3eAndroidUserActivity

If using an extension that was designed for s3eAndroidUserActivity, it should
have setup instructions.

I'm using this for s3eAndroidFullscreen and s3eAndroidController/IwController

**Background:** Some Android features require extending the "main activity".
Usually this is becuase they need access to a callback/event that is only
available by overriding a method of the main activity. An example of this is
getting keyboard events. The Marmalade loader itself already extends the main
activity using a class called com.ideaworks3d.marmalade.LoaderActivity.

An extension can itself extend the marmalade activity and override events. It
then needs to use the deployment option android-custom-activity="com.my.activity"
(and usually user *super* to call the loaders version of any functions it
overrides). The problem is that if you have multiple extensions that need to
extend/override the activity then you would need to daisy-chain them, which
means editing and rebuilding them (annoying and awkward for git projects etc)

**Solution:** This extension is just a Java class that you can set as the
android-custom-activity and add simple calls into your own extensions.
Basically, extensions don't need rebuilding, instead you edit this simple
s3eAndroidUserActivity class to include the extensions needed. Hopefully this
will be replaced by an automatic equivalent in Marmalade, but this should do
in the meantime.


Where to put this
-----------------

Clone in Git and put your github root on the SDKs global search by adding the
following in < marmalade-root >/s3e/s3e-default.mkf:

        options { module_path="path/to/my/github/projects/root" }

Note that will get picked up by any projects that use an extension it
references. If you have multiple projects that dont use the same
activity-extending extensions, just put a custom copy of
s3eAndroidUserActivity next to each project and the project will pick up
that version instead of using s3e-default


How to use
----------

An extension that uses this should tell you what to do!

1) In that extension, edit source/android/s3eAndroidUserActivity.java:

   - Above the class definition, add an import, e.g. for s3eAndroidFullscreen:
   
        import com.nickchops.s3eAndroidFullscreen.s3eAndroidFullscreen;

   - In the class, add/edit any methods the extension needs access to, e.g.
     for s3eAndroidFullscreen:
   
        @Override
        public void onWindowFocusChanged(boolean hasFocus)
        {
            super.onWindowFocusChanged(hasFocus);
        
            s3eAndroidFullscreen.onWindowFocusChanged(hasFocus);
        }

2) Edit s3eAndroidUserActivity_android_java.mkb to import the extension's java
   library. e.g.
   
        librarypath "../s3eAndroidFullscreen/lib/android/s3eAndroidFullscreen.jar"
        
3) Run s3eAndroidUserActivity_android_java.mkb to rebuild any time you edit the
   .java file (no additional tools, or Android SDK needed to build that)

You dont need to edit the extensions (e.g. s3eAndroidFullscreen) or include
s3eAndroidUserActivity in your app.


Writing an extension to use s3eAndroidUserActivity
--------------------------------------------------

Take a look at the commented out examples in s3eAndroidUserActivity.java and
then at www.github.com/nickchops/s3eAndroidFullscreen and 
www.github.com/nickchops/s3eAndroidController. Should be fairly
obvious how it works...

1) Give your extension class a package name, e.g.

        package com.nickchops.s3eAndroidFullscreen;

   Note that this means in source/android/myextension_platform.cpp you 
   will need to use the package name when looking for the class, e.g.
   
        s3eEdkAndroidFindClass("com/nickchops/s3eAndroidController/s3eAndroidController");
   
2) Declare the class that you want to be called from the activity as *public*.

3) Declare methods you want to be called from the activity in your extension's
   class. These need to be *public static*. NB, that means any class
   variables the methods access need to be static as well. Its recommended to
   name them to match the activity methods they will be called from for ease
   of identification.
   
4) Tell users how to edit s3eAndroidUserActivity in your readme!


------------------------------------------------------------------------------------------
(C) 2015 Nick Smith.

All code is provided under the MIT license unless stated otherwise:

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.

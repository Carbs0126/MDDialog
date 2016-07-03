# MDDialog
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-MDDialog-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/3822)

## Abstract
a material designed style dialog, can add operation of content view, set messages, respond to onclick of messages items and so on

## Introduction
an MDDialog inspired by the Material Design Pattern. You can get a MD style dialog quickly by using MDDialog Builder.
this MDDialog has many interesting configurations such as :
  1. you can hide or show title or positive/negative button(or both)
  2. you can add a customized view into the MDDialog, and can add code to control the customized view in Builder' fuction "setContentViewOperator(...)"
  3. you can set an String[] messages into MDDialog, and each item of messages will be one view in MDDialog, and can set setOnItemClickListener(...) for each item of messages.
  4. you can customize the corner's radius of MDDialog.
  5. MDDialog has the pressed effect of each messages item, and the shape of pressed effect is the same as item's shape
  6. two ways to set the MDDialog width, the ratio of screen width, or the exact dimension
  Author:Carbs.Wang
  
  Email:yeah0126#yeah.net

## Screenshot
<center>
![you can check the MDDialog_setView.png](https://github.com/Carbs0126/Screenshot/blob/master/md_dialog_setview.png)
</center><br>
<center>
![SegmentControlView MDDialog_setMessages](https://github.com/Carbs0126/Screenshot/blob/master/md_dialog_setmessages.png)
</center>

## Example
 first add dependences
```
  dependencies {
    compile 'cn.carbs.android:MDDialog:1.0.0'
  }
```
 how to build the MDDialog in java code
```
two mode to create MDDialog
  1.set customize view :
  new MDDialog.Builder(ActivityMain.this)
//              .setContentView(customizedView)
                .setContentView(R.layout.content_dialog)
                .setContentViewOperator(new MDDialog.ContentViewOperator() {
                  @Override
                  public void operate(View contentView) {
                    EditText et = (EditText) contentView.findViewById(R.id.edit0);
                    et.setHint("hint set in operator");
                  }
                })
                .setTitle("添加")
                .setNegativeButton(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                  }
                })
                .setPositiveButton(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                  }
                })
                .setPositiveButtonMultiListener(new MDDialog.OnMultiClickListener() {
                  @Override
                    public void onClick(View clickedView, View contentView) {
                      EditText et = (EditText) contentView.findViewById(R.id.edit0);
                      Toast.makeText(getApplicationContext(), "edittext 0 : " + et.getText(), Toast.LENGTH_SHORT).show();
                    }
                  })
                .setNegativeButtonMultiListener(new MDDialog.OnMultiClickListener() {
                  @Override
                  public void onClick(View clickedView, View contentView) {
                    EditText et = (EditText) contentView.findViewById(R.id.edit1);
                    Toast.makeText(getApplicationContext(), "edittext 1 : " + et.getText(), Toast.LENGTH_SHORT).show();
                  }
                })
                .setWidthMaxDp(600)
//              .setShowTitle(false)//default is true
//              .setShowButtons(true)//default is true
                .create()
              .show();
            
    2.set String[] messages
    
    final String[] messages = new String[]{"两个黄鹂鸣翠柳，一行白鹭上青天。",
                "窗含西岭千秋雪，门泊东吴万里船。",
                "君不见，黄河之水天上来，奔流到海不复回；君不见，高堂明镜悲白发，朝如青丝暮如雪。"};
    new MDDialog.Builder(ActivityMain.this)
                        .setMessages(messages)
                        .setTitle("一首古诗")
                        .setNegativeButton(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                            }
                        })
                        .setPositiveButton(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(), "positive", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setOnItemClickListener(new MDDialog.OnItemClickListener() {
                            @Override
                            public void onItemClicked(int index) {
                                Toast.makeText(getApplicationContext(), messages[index], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setWidthMaxDp(600)
                        .setShowTitle(false)
                        .setShowButtons(true)
                        .create()
                      .show();
    
```

## License

    Copyright 2016 Carbs.Wang (MDDialog)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.




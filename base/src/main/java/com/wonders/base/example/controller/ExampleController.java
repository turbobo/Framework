package com.wonders.base.example.controller;

import com.wonders.base.common.CommonService;
import com.wonders.base.example.entity.ExampleEntity;
import gov.util.jpa.Query;
import io.swagger.annotations.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import java.util.List;

import net.sf.json.JSONArray;

//当前类的描述
@Api(tags = "部门模块接口", description = "后台管理服务部门模块接口")
@RestController
//@ResponseBody
//@RestController
@RequestMapping(value = "/example")
public class ExampleController {
    @Autowired
    private CommonService commonService;

    //请求格式为    /user?a=1&b=3
    @RequestMapping("/user")
    public Map<String, Object> user(String a, String b) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "lihui");
        map.put("email", "me@lihuia.com");
        map.put("website", "lihuia.com");
        return map;
    }

    /**
     * 新增or修改
     * @return
     */
    @RequestMapping(value = "/saveOrEdit/{stId}/{stName}/{stIdCard}/{stAddress}" , method = RequestMethod.POST)
    //描述一个http请求的操作
    @ApiOperation(value = "新增or修改一个用户",httpMethod = "POST")
    //http请求参数集
    @ApiImplicitParams({
            //参数的描述
            @ApiImplicitParam(name = "stId", value = "用户id", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "stName", value = "用户名", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "stIdCard", value = "用户身份证号码", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "stAddress", value = "用户地址", required = true, dataType = "String", paramType = "path")
    })
    public Object Save(@PathVariable("stId") String stId
            , @PathVariable("stName") String stName
            , @PathVariable("stIdCard") String stIdCard
            , @PathVariable("stAddress") String stAddress) throws Exception{
        ExampleEntity gsEntity=new ExampleEntity();
        if(StringUtils.isNotBlank(stId)){  //字符串非空
            gsEntity=commonService.find(ExampleEntity.class,stId);
            //如果该id的用户不存在时才新增
            if (gsEntity == null)
                gsEntity = new ExampleEntity();
        }
        if(StringUtils.isNotBlank(stName)){
            gsEntity.setStName(stName);
        }
        if(StringUtils.isNotBlank(stIdCard)){
            gsEntity.setStIdCard(stIdCard);
        }
        if(StringUtils.isNotBlank(stAddress)){
            gsEntity.setStAddress(stAddress);
        }
        commonService.save(gsEntity);
        return "success";
    }


    /**
     * 查询列表
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有用户", httpMethod = "GET")
    public List<ExampleEntity> getList(){
//    public List<Map> getList(){
//    public Map<String, Object> getList(){
        Query query= Query.from(ExampleEntity.class);
        List<ExampleEntity> list= commonService.findAll(query);
//        List<Map> list2=new ArrayList<Map>();
//        for(int i=0;i<list.size();i++){
//            Map map=new HashMap();
//            map.put("key",(i+1)+"");
//            map.put("stId", list.get(i).getStId());
//            map.put("stName", list.get(i).getStName());
//            map.put("stIdCard", list.get(i).getStIdCard());
//            map.put("stAddress", list.get(i).getStAddress());
//            map.put("creatorId", list.get(i).getCreatorId());
//            map.put("creatorName", list.get(i).getCreatorName());
//            map.put("createTime", list.get(i).getCreateTime());
//            map.put("updateTime", list.get(i).getUpdateTime());
//            map.put("updateTime", list.get(i).getStatus());
//            list2.add(map);
//        }

        //list转为json
//        JSONArray json=JSONArray.fromObject(list);
//        System.out.println(list.getClass().toString());
//        System.out.println(list2);
//                System.out.println(json);
//        Map<String, Object> map= new HashMap<>();
//        return json;
        return list;


//        Map<String, Object> map = new HashMap<>();
//        map.put("key",1);
//        map.put("stId", list.get(0).getStId());
//        map.put("stName", list.get(0).getStName());
//        map.put("stIdCard", list.get(0).getStIdCard());
//        map.put("stAddress", list.get(0).getStAddress());
//        map.put("creatorId", list.get(0).getCreatorId());
//        map.put("creatorName", list.get(0).getCreatorName());
//        map.put("createTime", list.get(0).getCreateTime());
//        map.put("updateTime", list.get(0).getUpdateTime());
//        map.put("updateTime", list.get(0).getStatus());
//        return map;
    }

    @RequestMapping(value = "/getDetail/{stId}" , method = RequestMethod.GET)
    @ApiOperation(value = "查询一个用户详细信息", httpMethod = "GET")
    @ApiImplicitParam(name = "stId", value = "用户Id", dataType = "String", required = true, paramType = "path")
    public ExampleEntity getDetail(@PathVariable("stId") String stId){
        ExampleEntity embo = commonService.find(ExampleEntity.class,stId);
        return embo;
    }

    /**
     * 删除
     * @param stId
     * @return
     */
    @RequestMapping(value = "/delete/{stId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "stId", value = "用户Id", dataType = "String", required = true, paramType = "path")
    public Object delete(@PathVariable("stId") String stId){
        try{
            if(StringUtils.isNotBlank(stId)){
                commonService.delete(ExampleEntity.class,stId);
                return "success";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "error";
    }

}

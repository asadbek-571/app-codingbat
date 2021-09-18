package com.codingbat.mapper;


import com.codingbat.entity.Language;
import com.codingbat.entity.Result;
import com.codingbat.entity.Task;
import com.codingbat.entity.User;
import com.codingbat.model.LanguageDto;
import com.codingbat.model.ResultDto;
import com.codingbat.model.TaskDto;
import com.codingbat.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;


import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
@Component
public interface MapstructMapper {

    /**
     * User
     */
    User toUser(UserDto dto);

    User toUser(@MappingTarget User user, UserDto dto);

    UserDto toUserDto(User user);

    /**
     * Language
     */
    Language toLanguage(LanguageDto dto);

    Language toLanguage(@MappingTarget Language language, LanguageDto dto);

    LanguageDto toLanguageDto(Language language);

    /**
     * Result
     */
    Result toResult(ResultDto dto);

    Result toResult(@MappingTarget Result result, ResultDto dto);

    ResultDto toResultDto(Result result);

    /**
     * Task
     */
    Task toTask(TaskDto dto);

    Task toTask(@MappingTarget Task task, TaskDto dto);

    TaskDto toTaskDto(Task worker);
}

package site.licsber.shop.service;

import site.licsber.shop.model.Res;
import site.licsber.shop.model.form.SubmitCommentForm;

public interface SubmitCommentService {

    Res submitComment(SubmitCommentForm submitCommentForm);

}
